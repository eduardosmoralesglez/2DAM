export interface Book {
    id: number;
    title: string;
    publicationYear: number;
    author: string;
}

export type NewBook = Omit<Book, 'id'>;
