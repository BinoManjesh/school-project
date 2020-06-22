class Author {

    int authorNum;
    String name;

    Author() {
        authorNum = 0;
        name = null;
    }

    Author(int authorNum, String name) {
        this.authorNum = authorNum;
        this.name = name;
    }

    void show() {
        System.out.println("Author number: " + authorNum +
                "\nAuthor Name: " + name);
    }
}
