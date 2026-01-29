import { useEffect, useState } from "react";
import api from "../services/api";

const USER_ID = 2;

function MyLearningPaths() {
  const [userPaths, setUserPaths] = useState([]);
  const [pathDetails, setPathDetails] = useState({});
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    loadUserPaths();
  }, []);

  const loadUserPaths = async () => {
    try {
      setLoading(true);

      // 1️⃣ get user-path mappings
      const mappingRes = await api.get(`/users/${USER_ID}/paths`);
      const mappings = mappingRes.data;
      setUserPaths(mappings);

      // 2️⃣ fetch path details in parallel
      const detailResponses = await Promise.all(
        mappings.map(m =>
          api
            .get(`/learning-paths/${m.learningPathId}`)
            .then(res => ({ id: m.learningPathId, data: res.data }))
        )
      );

      // 3️⃣ build lookup map
      const detailMap = {};
      detailResponses.forEach(d => {
        detailMap[d.id] = d.data;
      });

      setPathDetails(detailMap);
    } catch (err) {
      console.error("Failed loading learning paths", err);
    } finally {
      setLoading(false);
    }
  };

  const activatePath = async (pathId) => {
    await api.put(`/users/${USER_ID}/paths/${pathId}/activate`);
    loadUserPaths();
  };

  if (loading) {
    return <div className="card">Loading learning paths...</div>;
  }

  return (
    <div className="card">
      <h2>My Learning Paths</h2>

      {userPaths.map(p => {
        const path = pathDetails[p.learningPathId];

        return (
          <div key={p.learningPathId} className="path-box">
            <strong>
              {path ? path.name : "Loading path name..."}
            </strong>

            <p>
              Status:{" "}
              <span
                style={{
                  color: p.status === "ACTIVE" ? "green" : "gray",
                  fontWeight: "bold"
                }}
              >
                {p.status}
              </span>
            </p>

            {p.status !== "ACTIVE" && (
              <button
                className="primary-btn"
                onClick={() => activatePath(p.learningPathId)}
              >
                Set Active
              </button>
            )}
          </div>
        );
      })}
    </div>
  );
}

export default MyLearningPaths;
