import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from "../services/api";

const USER_ID = 1;

function PathDetails() {
  const { pathId } = useParams();
  const [path, setPath] = useState(null);

  useEffect(() => {
    api.get(`/learning-paths/${pathId}`)
      .then(res => setPath(res.data))
      .catch(err => console.error(err));
  }, [pathId]);

  const updateProgress = (skillId, status) => {
    api.put(`/users/${USER_ID}/skills/${skillId}/progress`, { status })
      .then(() => {
        // re-fetch path to reflect updates
        api.get(`/learning-paths/${pathId}`)
           .then(res => setPath(res.data));
      });
  };

  if (!path) return <p>Loading...</p>;

  return (
    <div className="card">
      <h2>{path.name}</h2>

      {path.skills.map(skill => (
        <div key={skill.id} className="skill-row">
          <span>{skill.name} ({skill.category})</span>

          <select
            defaultValue=""
            onChange={e => updateProgress(skill.id, e.target.value)}
          >
            <option value="" disabled>Set Status</option>
            <option value="NOT_STARTED">Not Started</option>
            <option value="IN_PROGRESS">In Progress</option>
            <option value="COMPLETED">Completed</option>
          </select>
        </div>
      ))}
    </div>
  );
}

export default PathDetails;
