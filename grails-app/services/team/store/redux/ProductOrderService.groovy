package team.store.redux

import grails.gorm.services.Service

@Service(ProductOrder)
interface ProductOrderService {

    ProductOrder get(Serializable id)

    List<ProductOrder> list(Map args)

    Long count()

    void delete(Serializable id)

    ProductOrder save(ProductOrder productOrder)

}