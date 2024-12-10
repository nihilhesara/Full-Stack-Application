import React, { useState } from 'react';
import './App.css';
import { sendTicketDetails, startBackend, stopBackend } from './api';

const App: React.FC = () => {
  const [totalNoTickets, setTotalNoTickets] = useState<string>('');
  const [ticketReleaseRate, setTicketReleaseRate] = useState<string>('');
  const [customerRetrievalRate, setCustomerRetrievalRate] = useState<string>('');
  const [maximumTicketCapacity, setMaximumTicketCapacity] = useState<string>('');

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>, setState: React.Dispatch<React.SetStateAction<string>>) => {
    const value = e.target.value;
    if (/^\d*$/.test(value)) {
      setState(value);
    }
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    const ticketDetails = {
      totalNoTickets: parseInt(totalNoTickets),
      ticketReleaseRate: parseInt(ticketReleaseRate),
      customerRetrievalRate: parseInt(customerRetrievalRate),
      maximumTicketCapacity: parseInt(maximumTicketCapacity),
    };
    try {
      const response = await sendTicketDetails(ticketDetails);
      console.log('Ticket details submitted successfully', response.data);
    } catch (error) {
      console.error('Error submitting ticket details', error);
    }
  };

  const handleClear = () => {
    setTotalNoTickets('');
    setTicketReleaseRate('');
    setCustomerRetrievalRate('');
    setMaximumTicketCapacity('');
  };

  const handleStart = async () => {
    try {
      const response = await startBackend();
      console.log('Backend started successfully', response.data);
    } catch (error) {
      console.error('Error starting backend', error);
    }
  };

  const handleStop = async () => {
    try {
      const response = await stopBackend();
      console.log('Backend stopped successfully', response.data);
    } catch (error) {
      console.error('Error stopping backend', error);
    }
  };

  return (
    <div className="App">
      <div className="Heading">
        <h1>Event Ticket Booking System</h1>
      </div>

      <div className="button-container">
        <div className="row">
          <button className="start-button" onClick={handleStart}>Start</button>
          <button className="stop-button" onClick={handleStop}>Stop</button>
        </div>
        <button className="config-button">Configuration</button>
      </div>

      <div className="Form">
        <form onSubmit={handleSubmit}>
          <fieldset>
            <legend>Ticket Details</legend>

            <label htmlFor="totalNoTickets">Total Number of Tickets</label>
            <input
              type="text"
              id="totalNoTickets"
              placeholder="Enter total ticket count"
              value={totalNoTickets}
              onChange={(e) => handleInputChange(e, setTotalNoTickets)}
            />

            <label htmlFor="ticketReleaseRate">Ticket Release Rate</label>
            <input
              type="text"
              id="ticketReleaseRate"
              placeholder="Enter release rate"
              value={ticketReleaseRate}
              onChange={(e) => handleInputChange(e, setTicketReleaseRate)}
            />

            <label htmlFor="customerRetrievalRate">Customer Retrieval Rate</label>
            <input
              type="text"
              id="customerRetrievalRate"
              placeholder="Enter retrieval rate"
              value={customerRetrievalRate}
              onChange={(e) => handleInputChange(e, setCustomerRetrievalRate)}
            />

            <label htmlFor="maximumTicketCapacity">Maximum Ticket Capacity</label>
            <input
              type="text"
              id="maximumTicketCapacity"
              placeholder="Enter maximum ticket capacity"
              value={maximumTicketCapacity}
              onChange={(e) => handleInputChange(e, setMaximumTicketCapacity)}
            />

            <input type="submit" value="Send" className="submit-button" />
            <input type="button" value="Clear" className="reset-button" onClick={handleClear} />
          </fieldset>
        </form>
      </div>
    </div>
  );
};

export default App;
