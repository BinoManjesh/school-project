class BookList extends Author {

    long bookNum;
    String bookName;
    float price;
    int edition;

    BookList(int authorNum, String name, long bookNum, String bookName, float price, int edition) {
        super(authorNum, name);
        this.bookNum = bookNum;
        this.bookName = bookName;
        this.price = price;
        this.edition = edition;
    }

    public static void main(String[] args) {
        BookList bookList = new BookList(37645236, "Jeff", 432647532L,
                "Adventures of Jeff", 399f, 69);
        bookList.show();
    }

    void show() {
        super.show();
        System.out.println("Book number: " + bookNum +
                "\nBook name: " + bookName +
                "\nPrice: " + price +
                "\nEdition: " + edition);
    }
}
