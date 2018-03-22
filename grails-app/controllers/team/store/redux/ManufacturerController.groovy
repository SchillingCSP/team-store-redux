package team.store.redux

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ManufacturerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Manufacturer.list(params), model:[manufacturerCount: Manufacturer.count()]
    }

    def show(Manufacturer manufacturer) {
        respond manufacturer
    }
    def report() {
        respond Manufacturer.list(), model:[manufacturerCount: Manufacturer.count()]
    }
    def create() {
        respond new Manufacturer(params)
    }

    @Transactional
    def save(Manufacturer manufacturer) {
        if (manufacturer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (manufacturer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond manufacturer.errors, view:'create'
            return
        }

        manufacturer.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'manufacturer.label', default: 'Manufacturer'), manufacturer.id])
                redirect manufacturer
            }
            '*' { respond manufacturer, [status: CREATED] }
        }
    }

    def edit(Manufacturer manufacturer) {
        respond manufacturer
    }

    @Transactional
    def update(Manufacturer manufacturer) {
        if (manufacturer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (manufacturer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond manufacturer.errors, view:'edit'
            return
        }

        manufacturer.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'manufacturer.label', default: 'Manufacturer'), manufacturer.id])
                redirect manufacturer
            }
            '*'{ respond manufacturer, [status: OK] }
        }
    }

    @Transactional
    def delete(Manufacturer manufacturer) {

        if (manufacturer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        manufacturer.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'manufacturer.label', default: 'Manufacturer'), manufacturer.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'manufacturer.label', default: 'Manufacturer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
