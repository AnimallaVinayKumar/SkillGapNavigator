import { useEffect, useState } from "react";
import api from "../services/api";

function SkillList() {
  const [skills, setSkills] = useState([]);

  useEffect(() => {
    api.get("/skills")
      .then(res => setSkills(res.data))
      .catch(console.error);
  }, []);

  return (
    <div className="card">
      <h2>Skills</h2>

      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
          </tr>
        </thead>

        <tbody>
          {skills.map(skill => (
            <tr key={skill.id}>
              <td>{skill.id}</td>
              <td>{skill.name}</td>
              <td>{skill.category}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default SkillList;
