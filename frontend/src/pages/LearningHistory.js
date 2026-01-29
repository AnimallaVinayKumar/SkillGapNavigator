import { useEffect, useState } from "react";
import api from "../services/api";

const USER_ID = 2;

function LearningHistory() {
  const [history, setHistory] = useState([]);

  useEffect(() => {
    api.get(`/users/${USER_ID}/skill-history`)
      .then(res => setHistory(res.data))
      .catch(console.error);
  }, []);

  return (
    <div className="page">
      <h2>Learning History</h2>

      {history.length === 0 && <p>No learning activity yet.</p>}

      {history.map(item => (
        <div key={item.skillId} className="path-box">
          <strong>{item.skillName}</strong>
          <p>Status: {item.status.replace("_", " ")}</p>
          <p>Started: {item.startedAt || "-"}</p>
          <p>Completed: {item.completedAt || "-"}</p>
          <p>Resource: {item.resourceUsed || "Not specified"}</p>
        </div>
      ))}
    </div>
  );
}

export default LearningHistory;
