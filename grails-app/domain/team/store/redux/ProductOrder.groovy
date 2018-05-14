package team.store.redux

class ProductOrder {

    String number
    Product product
    Double quantity

    static belongsTo = [user:User]

    static constraints = {
        number nullalbe:false
        product nullable:false
        quantity nullable:false
    }
}
