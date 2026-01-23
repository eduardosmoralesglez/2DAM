import { Component } from '@angular/core';
import { BooksService } from '../../services/editorial.service';

@Component({
  selector: 'app-books',
  imports: [],
  templateUrl: './books.component.html',
  styleUrl: './books.component.css'
})
export class BooksComponent {
  constructor(public booksService: BooksService) {}

  
}
