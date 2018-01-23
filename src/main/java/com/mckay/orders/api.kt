package com.mckay.orders

import io.swagger.annotations.Api
import io.swagger.jaxrs.config.BeanConfig
import javax.ws.rs.*
import javax.ws.rs.core.Application
import javax.ws.rs.core.MediaType

/**
 * Created by rm on 14/11/2017.
 */

@Path("orders")
@Api("orders")
class OrdersApi : Application() {

    init {
        println("OrdersApi initialized.")
        val beanConfig = BeanConfig()
        beanConfig.version = "0.0.1"
        beanConfig.title = "Orders REST API"
        beanConfig.description = "The REST API for the Orders site"
        beanConfig.schemes = arrayOf("http")
        beanConfig.basePath = "/api/"
        beanConfig.resourcePackage = "com.mckay.orders"
        beanConfig.scan = true
    }

    override fun getClasses(): Set<Class<*>> {
        println("getClasses called")
        return setOf(this.javaClass)
    }

    @GET
    @Path("xml")
    @Produces(MediaType.APPLICATION_XML)
    fun xml() = "msg" to "Hello World"

    @POST
    @Path("order/create")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    fun newmodel(o : PurchaseOrder) : String {

        return o.toString()

    }

    /**
     * Echo
     */
    @GET
    @Path("echo")
    @Produces(MediaType.APPLICATION_JSON)
    fun echo(@QueryParam("msg") msg: String = "Hello World") = mapOf("msg" to msg)


}