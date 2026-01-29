import { useEffect, useState } from "react";

const USER_ID = 2;

function Skills() {
  const [skills, setSkills] = useState([]);
  const [selected, setSelected] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/skills")
      .then(res => res.json())
      .then(setSkills);
  }, []);

  const toggle = (id) => {
    setSelected(prev =>
      prev.includes(id) ? prev.filter(x => x !== id) : [...prev, id]
    );
  };

  const save = () => {
    fetch(`http://localhost:8080/api/users/${USER_ID}/skills`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(selected)
    }).then(() => alert("Skills saved"));
  };

  return (
    <div className="page">
      <h2>My Skills</h2>

      {skills.map(skill => (
        <label key={skill.id} className="checkbox-item">
          <input
            type="checkbox"
            onChange={() => toggle(skill.id)}
          />
          {skill.name} ({skill.category})
        </label>
      ))}

      <br />
      <button onClick={save}>Save Skills</button>
    </div>
  );
}

export default Skills;
