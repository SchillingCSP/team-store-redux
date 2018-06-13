package team.store.redux

import grails.gorm.services.Service

@Service(ProductReview)
interface ProductReviewService {

    ProductReview get(Serializable id)

    List<ProductReview> list(Map args)

    Long count()

    void delete(Serializable id)

    ProductReview save(ProductReview productReview)

}