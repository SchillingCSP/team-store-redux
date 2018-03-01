package team.store.redux

class Manufacturer {

    String name

    String toString () {
        "$name"
    }

    static constraints = {
        name nullable: false, blank: false
    }
}