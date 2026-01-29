import { useEffect, useState } from "react";
import api from "../services/api";

const USER_ID = 2;

function Recommendations() {
  const [paths, setPaths] = useState([]);
  const [pathId, setPathId] = useState("");
  const [result, setResult] = useState(null);
  const [resources, setResources] = useState({});

  useEffect(() => {
    api.get(`/learning-paths/user/${USER_ID}`)
      .then(res => setPaths(res.data));
  }, []);

  const analyze = () => {
    api.get(`/recommendations/${USER_ID}/${pathId}`)
      .then(res => setResult(res.data));
  };

  const loadResources = (skillId) => {
    api.get(`/skills/${skillId}/resources`)
      .then(res => {
        setResources(prev => ({
          ...prev,
          [skillId]: Array.isArray(res.data) ? res.data : []
        }));
      });
  };

  return (
    <div className="page">
      <h2>Recommendations</h2>

      <select onChange={e => setPathId(e.target.value)}>
        <option value="">Select Learning Path</option>
        {paths.map(p => (
          <option key={p.id} value={p.id}>{p.name}</option>
        ))}
      </select>

      <button onClick={analyze}>Analyze</button>

      {result && result.recommendations.map(rec => (
        <div key={rec.skillId} className="path-box">
          <strong>{rec.skillName}</strong>
          <p>Category: {rec.category}</p>

          <button onClick={() => loadResources(rec.skillId)}>
            View Resources
          </button>

          {resources[rec.skillId]?.map((r, i) => (
            <div key={i}>
              {r.type}: <a href={r.url} target="_blank" rel="noreferrer">Open</a>
            </div>
          ))}
        </div>
      ))}
    </div>
  );
}

export default Recommendations;
