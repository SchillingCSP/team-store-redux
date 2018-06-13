package team.store.redux

class ProductReview {

    Integer score
    String comments
    User user
    Product product

    static constraints = {
        score inList: [1,2,3,4,5]
        user nullable:false
        comments()
        product nullable:false
    }
}
