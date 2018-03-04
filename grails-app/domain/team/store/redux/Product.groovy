package team.store.redux

class Product {
    String name
    String description
    Double price
    Category category
    Manufacturer manufacturer
    String rating
    Double score

    static constraints = {
        name nullable:false,blank:false,unique:true
        description nullable:false, blank:false
        price nullable:false
        category nullable:false
        manufacturer nullable:false
        rating nullable:false
        score nullable:false

    }
    String toString() {
        "$name by ${manufacturer?.name} price: $price, rating: $rating"
    }
}
