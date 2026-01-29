import { useEffect, useState } from "react";

const USER_ID = 2;

function LearningPaths() {
  const [paths, setPaths] = useState([]);

  useEffect(() => {
    fetch(`http://localhost:8080/api/learning-paths/user/${USER_ID}`)
      .then(res => res.json())
      .then(setPaths);
  }, []);

  return (
    <div className="page">
      <h2>Learning Paths</h2>

      {paths.map(path => (
        <div key={path.id} className="path-box">
          <strong>{path.name}</strong>
          <div>
            {path.skills.map(s => (
              <span key={s.id} className="skill-tag">{s.name}</span>
            ))}
          </div>
        </div>
      ))}
    </div>
  );
}

export default LearningPaths;
