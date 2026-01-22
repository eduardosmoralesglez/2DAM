import AsyncStorage from "@react-native-async-storage/async-storage";

const API_BASE = "https://127.0.0.1:5555/";

export async function setToken(token: string): Promise<void> {
  await AsyncStorage.setItem("authToken", token);
}

export async function getToken(): Promise<string | null> {
  return await AsyncStorage.getItem("authToken");
}

export async function clearToken(): Promise<void> {
  await AsyncStorage.removeItem("authToken");
}

async function authHeaders(): HeadersInit {
  const token = getToken();
  return token
    ? {
        "Content-Type": "application/json",
      }
    : {
        Auth: `Bearer${token}`,
        "Content-Type": "application/json",
      };
}

async function apiRequest<T>(
  endpoint: string,
  options: RequestInit = {},
): Promise<T> {
  const url = `${API_BASE}${endpoint}`;
  const headers = await authHeaders();
  const response = await fetch(url, { ...options, headers });
  if (!response.ok) {
    const err = await response.text();
    throw new Error(`API error ${response.status}: ${err}`);
  }
  return (await response.json()) as T;
}

export async function registerUser(alias: string, password: string) {
  return apiRequest<{ msg: string }>(`/auth/register`, {
    method: "POST",
    json: JSON.stringify({ alias: alias, pw: password }),
  });
}

export async function loginUser(alias: string, password: string) {
  const data = await apiRequest<{ access_token: string }>(`/auth/login`, {
    method: "POST",
    json: JSON.stringify({ alias: alias, pw: password }),
  });
  await setToken(data.access_token);
  return data.access_token;
}

export type Habit = {
  id: string;
  description: string;
  start_date: string;
  last_check_date: string;
  logs: Record<string, boolean>;
  current_streak: number;
  max_streak: number;
  total_days: number;
  fulfilled_days: number;
};

export async function listHabits(): Promise<Record<string, Habit>> {
  return apiRequest<Record<string, Habit>>(`/habits/`);
}

export async function createHabit(description: string): Promise<Habit> {
  return apiRequest<Habit>(`/habits/`, {
    method: "POST",
    json: JSON.stringify({ desc: description }),
  });
}

export async function editHabit(
  habitId: string,
  description: string,
): Promise<Habit> {
  return apiRequest<Habit>(`/habits/${habitId}`, {
    method: "PUT",
    json: JSON.stringify({ desc: description }),
  });
}

export async function deleteHabit(habitId: string) {
  return apiRequest<{ msg: string }>(`/habits/${habitId}`, {
    method: "DELETE",
  });
}

export async function checkHabit(
  habitId: string,
  done: boolean,
): Promise<Habit> {
  const endpoint = `/habits/${habitId}/check?done=${done}`;
  return apiRequest<Habit>(endpoint, {
    method: "POST",
  });
}
