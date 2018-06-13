package team.store.redux

class Product {
    String name
    String description
    Double price
    Category category
    Manufacturer manufacturer
    String rating
    // uri to the picture
    String pic
    Double score
    Double calculatedScore

    static transients = ['calculatedScore']

    static constraints = {
        name nullable:false,blank:false,unique:true
        description nullable:false, blank:false
        price nullable:false
        category nullable:false
        manufacturer nullable:false
        rating nullable:true
        calculatedScore nullable: true, min: new Double(0.0), max: new Double(5.0)

    }
    String toString() {
        "$name by ${manufacturer?.name} price: $price, rating: $rating"
    }

    /**
     * Return the average score
     * @return
     */
    Double getCalculatedScore() {
        def reviews = ProductReview.findAllByProduct(this.id)
        reviews.size() == 0 ? 5 : reviews.collect {it.score}.sum() / reviews.size()
    }

}
