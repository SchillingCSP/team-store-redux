package team.store.redux

class User {

    String userName
    String password
    String email
    String cardType
    String nameOnCard
    String cardNumber
    Integer expirationMonth
    Integer expirationYear
    Integer cardCode
    String address
    String city
    String state
    String zipCode

    static hasMany = [orders:ProductOrder]

    static constraints = {
        userName size: 5..15, blank: false, unique: true
        password size: 5..15, blank: false
        email email: true, blank: false
        cardType inList: ['Visa','MasterCard','American Express','Discover'], blank:false
        nameOnCard blank: false
        cardNumber size: 16..16, blank: false
        expirationMonth inList: [1,2,3,4,5,6,7,8,9,10,11,12]
        expirationYear inList: [2018,2019,2020,2021,2022,2023,2024,2025,2026]
        cardCode size: 3..3
        address blank:false
        city blank:false
        state blank:false
        zipCode blank:false
    }
}
