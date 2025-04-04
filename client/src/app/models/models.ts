export interface User {
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  enabled: boolean;
}
export interface Group {
  id: number;
  name: string;
  address?: string;
  description?: string;
}
