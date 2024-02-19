package com.example.ss9_app_muon_sach.controller;


import com.example.ss9_app_muon_sach.exception.CleanOut;
import com.example.ss9_app_muon_sach.model.Book;
import com.example.ss9_app_muon_sach.model.Person;
import com.example.ss9_app_muon_sach.service.book.IBookService;
import com.example.ss9_app_muon_sach.service.person.IPersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IPersonService iPersonService;

    @GetMapping("")
    public String showView(Model model) {
        model.addAttribute("listBook", iBookService.findAll());
        return "/list";
    }

    @GetMapping("/view-create")
    public String showViewCreate(Model model) {
        model.addAttribute("book", new Book());
        return "/create";
    }

    @PostMapping("/create-book")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "/create";
        }
        iBookService.update(book);
        return "redirect:/book";
    }

    @GetMapping("/muon")
    public String muonSach(@RequestParam int id, Model model) throws CleanOut {
        Book book1 = iBookService.findById(id);
        if (book1.getQuantityBook() == 0) {
            throw new CleanOut("Het Sach");
        } else {
            book1.setQuantityBook(book1.getQuantityBook() - 1);
            iBookService.update(book1);
            Person personX = new Person();//  đây là tạo đối tượng mới
            personX.setIdPerson(iPersonService.idPersonRandom()); // khóa chính id cũng là mới
            personX.setNamePerson("Bich");
            personX.setNameBookBorrwed(book1.getNameBook());
            personX.setBook(book1);
            iPersonService.update(personX);
            return "redirect:/book";
        }
    }

    @ExceptionHandler(CleanOut.class)
    public String number0() {
        return "/error-null";
    }

    @GetMapping("/tra")
    public String viewTraSach(Model model) {
        model.addAttribute("personX", new Person());
        return "/give-back";
    }

    @PostMapping("/tra-sach")
    public String traSachPost(@Valid @ModelAttribute("personX") Person personX, BindingResult bindingResult, Model model) {

        Person person = iPersonService.findById(personX.getIdPerson());//trả về đối tượng dựa vào mã user nhập vào(PK of person)
        new Person().validate(personX, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/give-back";
        }

        if (person == null) {
            model.addAttribute("error", "Ma KHONG ton tai!");
            return "/give-back";
        }
        Book bookX = iBookService.findById(person.getBook().getIdBook());//tìm Book dựa trên FK of Person(liên kết PM Book)
        bookX.setQuantityBook(bookX.getQuantityBook() + 1); // tăng số lượng Book tìm được lên 1
        iBookService.update(bookX); // cập nhật lại số lượng
        iPersonService.delete(personX.getIdPerson()); // trả xong rồi xóa person (vì mqh n-1)
        return "redirect:/book";
    }
    @GetMapping("/doi")
    public String doiSach(@RequestParam int id){
        Book book = iBookService.findById(id);
        book.setQuantityBook(18);
        book.setNameBook("Sach tieu lam");
//        book.setIdBook(333);
        iBookService.update(book);
        return "redirect:/book";
    }


//<form th:action="@{/book/tra-sach}" method="post" th:object="${personX}">
//    Nhập mã trả sách : <input th:field="*{idPerson}" type="text">
//    <small style="color: red" th:if="${#fields.hasErrors('idPerson')}" th:errors="*{idPerson}"></small>
//    <small style="color: red" th:if="${error}" th:text="${error}"></small>
//    <button>Trả Sách</button>
//</form>
}
