import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Home from "./pages/Home";
import Profile from "./pages/Profile";
import Skills from "./pages/Skills";
import LearningPaths from "./pages/LearningPaths";
import MyLearningPaths from "./pages/MyLearningPaths";
import LearningHistory from "./pages/LearningHistory";
import Recommendations from "./pages/Recommendations";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/profile" element={<Profile />} />
        <Route path="/skills" element={<Skills />} />
        <Route path="/learning-paths" element={<LearningPaths />} />
        <Route path="/paths" element={<MyLearningPaths />} />
        <Route path="/history" element={<LearningHistory />} />
        <Route path="/recommendations" element={<Recommendations />} />
      </Routes>
    </Router>
  );
}

export default App;
