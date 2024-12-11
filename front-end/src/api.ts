import axios from 'axios';

// Create an instance of axios with default configuration
const api = axios.create({
  baseURL: 'http://localhost:8080', // Set the base URL for the backend API
  headers: {
    'Content-Type': 'application/json', // Set the content type header to JSON
  },
});

// Define the interface for the ticket details
interface TicketDetails {
  totalNoTickets: number;
  ticketReleaseRate: number;
  customerRetrievalRate: number;
  maximumTicketCapacity: number;
}

// Function to send ticket details to the backend
export const sendTicketDetails = async (ticketDetails: TicketDetails) => {
  return await api.post('/api/submit', ticketDetails);
};

// Function to start the backend server
export const startBackend = async () => {
  return await api.post('/api/start');
};

// Function to stop the backend server
export const stopBackend = async () => {
  return await api.post('/api/stop');
};
