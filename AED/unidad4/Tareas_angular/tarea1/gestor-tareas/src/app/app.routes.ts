import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { TasksComponent } from './pages/tasks/tasks.component';
import { TaskNewComponent } from './pages/task-new/task-new.component';
import { TaskInfoComponent } from './pages/task-info/task-info.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'tareas', component: TasksComponent },
  { path: 'tareas/nueva', component: TaskNewComponent },
  { path: 'tareas/info', component: TaskInfoComponent},
  { path: '**', redirectTo: '' },
];