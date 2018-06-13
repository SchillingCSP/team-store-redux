package team.store.redux

class BootStrap {

    def init = { servletContext ->
        def cat1 = new Category(name:'Category One').save(failOnError:true)
        def mfg1 = new Manufacturer(name:'Manny One').save(failOnError:true)
        def prod1 = new Product(category:cat1,manufacturer:mfg1,name:'Prod 1', description:'Described',price:1.0,rating:'5',score:5,pic:'https://images.yourstory.com/2016/08/125-fall-in-love.png').save(failOnError:true)
        def user = new User(
                userName: 'jack_bubba',
                password: 'xyzxyzxyz',
                email:'jack@bubba.com',
                cardType: 'Visa',
                nameOnCard: 'Jack Bubba',
                cardNumber:'4234123412341234',
                expirationMonth: 2,
                expirationYear: 2022,
                cardCode: 123,
                address: '1 Main St',
                city: 'Morrow',
                state: 'Ohio',
                zipCode: '45152'
        ).save(failOnError:true);


        new ProductOrder(number:'1',product:prod1,quantity:2,user:user).save(failOnError:true);
        new ProductReview(user:user,score:4,product:prod1,comments:'Wow, great!').save(failOnError:true)
    }
    def destroy = {
    }
}
