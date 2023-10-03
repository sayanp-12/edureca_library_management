package com.sayan.assmnt.libmngmnt.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayan.assmnt.libmngmnt.entity.Author;
import com.sayan.assmnt.libmngmnt.entity.Book;
import com.sayan.assmnt.libmngmnt.entity.Borrower;
import com.sayan.assmnt.libmngmnt.entity.Genre;
import com.sayan.assmnt.libmngmnt.entity.Library;
import com.sayan.assmnt.libmngmnt.repository.AuthorRepository;
import com.sayan.assmnt.libmngmnt.repository.BorrowerRepository;
import com.sayan.assmnt.libmngmnt.repository.GenreRepository;
import com.sayan.assmnt.libmngmnt.repository.LibraryRepository;

@Service
public class CommonService {
    
    private final GenreRepository _genreRepository;
    private final AuthorRepository _auAuthorRepository;
    private final  LibraryRepository _LibraryRepository;
    private final  BorrowerRepository _borrowerRepository;
    Logger logger = LoggerFactory.getLogger(CommonService.class);

    @Autowired
    public CommonService(GenreRepository genreRepository, AuthorRepository authorRepository, LibraryRepository libraryRepository, BorrowerRepository borrowerRepository) {
        this._genreRepository = genreRepository;
        this._auAuthorRepository = authorRepository;
        this._LibraryRepository = libraryRepository;
        this._borrowerRepository = borrowerRepository;
    }

    public List<Book> getAllBooksByGenre(Long id)
    {
        try {
            Genre genres = _genreRepository.findById(id).get();
            return (List<Book>) genres.getBooks();
        } catch (Exception ex) {
            logger.error("Error in CommonService --> getAllBooksByGenre " + ex);
            throw ex;
        }
    }

    public List<Book> getAllBooksByAuthor(Long id)
    {
        try {
            Author authors = _auAuthorRepository.findById(id).get();
            return (List<Book>) authors.getBooks();
        } catch (Exception ex) {
            logger.error("Error in CommonService --> getAllBooksByAuthor " + ex);
            throw ex;
        }
    }

    public List<Book> getAllBooksBylibrary_branch(Long id)
    {
        try {
            Library library = _LibraryRepository.findById(id).get();
            return (List<Book>) library.getBooks();
        } catch (Exception ex) {
            logger.error("Error in CommonService --> getAllBooksBylibrary_branch " + ex);
            throw ex;
        }
    }

    public List<Book> getAllBooksByBorrower(Long id)
    {
        try {
            Borrower borrower = _borrowerRepository.findById(id).get();
            return (List<Book>) borrower.getBooks();
        } catch (Exception ex) {
            logger.error("Error in CommonService --> getAllBooksByBorrower " + ex);
            throw ex;
        }
    }
}
