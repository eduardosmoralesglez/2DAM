import { Injectable } from "@angular/core";
import { NewBook, Book } from "../models/editorial.model";
import { API_URL } from "../utils/api";

@Injectable({providedIn: 'root'})
export class BooksService {

  async list(): Promise<Book[]> {
    const data = await fetch(API_URL+'/api/v1/books', )
  }
}
