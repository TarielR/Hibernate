import dao.BookDAO;
import dao.HibernateUtils;
import models.BookEntity;

public class App {


    public static void main(final String[] args) throws Exception {
        BookDAO bookDAO = new BookDAO();

        BookEntity book = new BookEntity();
        book.setTitle("New book.");
        book.setAuthor("New Author.");
        book.setPrice(999);
        book.setId(7L);

        BookEntity newbook = new BookEntity();
        newbook.setTitle("Any book.");
        newbook.setAuthor("Any Author.");
        newbook.setPrice(1500);
        newbook.setId(2L);

        //bookDAO.create(book);
        //System.out.println(bookDAO.findAll());
        bookDAO.update(book);
        //System.out.println(bookDAO.findAll());
        bookDAO.delete(newbook);
        //System.out.println(bookDAO.findAll());
        HibernateUtils.shutdown();
    }
}