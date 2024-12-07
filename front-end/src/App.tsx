// src/App.tsx
import React, { useState } from 'react';
import './App.css';

const App: React.FC = () => {
  const [totalTicket, setTotalTicket] = useState('');
  const [releaseRate, setReleaseRate] = useState('');
  const [retrievalRate, setRetrievalRate] = useState('');
  const [maxTicketCapacity, setMaxTicketCapacity] = useState('');

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>, setState: React.Dispatch<React.SetStateAction<string>>) => {
    const value = e.target.value;
    if (/^\d*$/.test(value)) {  // Regex to allow only integer values
      setState(value);
    }
  };

  return (
    <div className="App">
      <div className="Heading">
        <h1>Event Ticket Booking System</h1>
      </div>

      <div className="button-container">
        <div className="row">
          <button className="start-button">Start</button>
          <button className="stop-button">Stop</button>
        </div>
        <button className="config-button">Configuration</button>
      </div>

      <div className="Form">
        <fieldset>
          <legend>Ticket Details</legend>

          <label htmlFor="totalTicket">Total Number of Tickets</label>
          <input
            type="text"
            id="totalTicket"
            placeholder="Enter total ticket count"
            value={totalTicket}
            onChange={(e) => handleInputChange(e, setTotalTicket)}
          />

          <label htmlFor="releaseRate">Ticket Release Rate</label>
          <input
            type="text"
            id="releaseRate"
            placeholder="Enter release rate"
            value={releaseRate}
            onChange={(e) => handleInputChange(e, setReleaseRate)}
          />

          <label htmlFor="retrievalRate">Customer Retrieval Rate</label>
          <input
            type="text"
            id="retrievalRate"
            placeholder="Enter retrieval rate"
            value={retrievalRate}
            onChange={(e) => handleInputChange(e, setRetrievalRate)}
          />

          <label htmlFor="maxTicketCapacity">Maximum Ticket Capacity</label>
          <input
            type="text"
            id="maxTicketCapacity"
            placeholder="Enter maximum ticket capacity"
            value={maxTicketCapacity}
            onChange={(e) => handleInputChange(e, setMaxTicketCapacity)}
          />

          <input type="submit" value="Send" className="submit-button" />
          <input type="reset" value="Clear" className="reset-button" />
        </fieldset>
      </div>
    </div>
  );
};

export default App;
