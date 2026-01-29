import { useEffect, useState } from "react";
import api from "../services/api";

const USER_ID = 1;

function LearningPathList() {
  const [paths, setPaths] = useState([]);
  const [refresh, setRefresh] = useState(false);

  useEffect(() => {
    api.get(`/learning-paths/user/${USER_ID}`)
      .then(res => setPaths(res.data))
      .catch(console.error);
  }, [refresh]);

  const updateProgress = (skillId, status) => {
    api.put(`/users/${USER_ID}/skills/${skillId}/progress`, { status })
      .then(() => setRefresh(!refresh))
      .catch(console.error);
  };

  if (paths.length === 0) {
    return <p>No learning paths assigned.</p>;
  }

  return (
    <div className="card">
      <h2>My Learning Paths</h2>

      {paths.map(path => (
        <div key={path.id} className="path-box">
          <h3>{path.name}</h3>

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
      ))}
    </div>
  );
}

export default LearningPathList;
