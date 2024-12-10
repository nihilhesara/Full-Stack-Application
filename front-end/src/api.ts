import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080',
  headers: {
    'Content-Type': 'application/json',
  },
});

interface TicketDetails {
  totalNoTickets: number;
  ticketReleaseRate: number;
  customerRetrievalRate: number;
  maximumTicketCapacity: number;
}

export const sendTicketDetails = async (ticketDetails: TicketDetails) => {
  return await api.post('/api/submit', ticketDetails);
};

export const startBackend = async () => {
  return await api.post('/api/start');
};

export const stopBackend = async () => {
  return await api.post('/api/stop');
};
