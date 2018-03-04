package team.store.redux

class BootStrap {

    def init = { servletContext ->
        def cat1 = new Category(name:'Category One').save(failOnError:true)
        def mfg1 = new Manufacturer(name:'Manny One').save(failOnError:true)
        new Product(category:cat1,manufacturer:mfg1,name:'Prod 1', description:'Described',price:1.0,rating:'5',score:1).save(failOnError:true)
    }
    def destroy = {
    }
}
