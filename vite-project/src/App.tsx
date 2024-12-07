// src/App.tsx
import React from 'react';
import './App.css';

const App: React.FC = () => {
  return (
    <div className="App">
      <button className="start-button">Start</button>
      <button className="stop-button">Stop</button>
      <button className="config-button">Configuration</button>
    </div>
  );
};

export default App;
