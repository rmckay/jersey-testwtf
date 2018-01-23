package com.mckay
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
import com.fasterxml.jackson.jaxrs.xml.JacksonJaxbXMLProvider
import com.fasterxml.jackson.jaxrs.xml.JacksonXMLProvider
import com.mckay.orders.OrdersApi
import org.glassfish.jersey.server.ResourceConfig
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.ContextHandlerCollection
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletHolder
import org.glassfish.jersey.media.multipart.MultiPartFeature
import org.glassfish.jersey.servlet.ServletContainer

import org.eclipse.jetty.webapp.FragmentConfiguration
import org.eclipse.jetty.webapp.MetaInfConfiguration
import org.eclipse.jetty.webapp.WebAppContext
import org.eclipse.jetty.webapp.WebInfConfiguration
import org.eclipse.jetty.webapp.WebXmlConfiguration
import org.eclipse.jetty.annotations.AnnotationConfiguration
import org.eclipse.jetty.plus.webapp.EnvConfiguration
import org.eclipse.jetty.plus.webapp.PlusConfiguration


/**
 * Created by rm on 14/11/2017.
 */


fun main(args: Array<String>) {

    val server = Server(8080)
    val api = OrdersApi()
    val rs = ResourceConfig()
    rs.packages("com.mckay.orders", "io.swagger.jaxrs.listing")
    rs.register(JacksonXMLProvider::class.java)
    rs.register(JacksonJaxbXMLProvider::class.java)
    rs.register(JacksonJsonProvider::class.java)
    rs.register(JacksonJaxbJsonProvider::class.java)
    rs.register(MultiPartFeature::class.java)
    rs.register(api)


    val wcon = WebAppContext()
    wcon.setResourceBase("src/web")
    wcon.setContextPath("/")
    wcon.setConfigurations(arrayOf<org.eclipse.jetty.webapp.Configuration>(AnnotationConfiguration(), WebXmlConfiguration(), WebInfConfiguration(), PlusConfiguration(), MetaInfConfiguration(), FragmentConfiguration(), EnvConfiguration()))
    wcon.setParentLoaderPriority(true)
    wcon.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/[^/]*jstl.*\\.jar$")

    val servlet = ServletHolder(ServletContainer(rs))

    val apicontext = ServletContextHandler(server, "/api/*")
    apicontext.addServlet(servlet, "/*")

    val handlers = ContextHandlerCollection()
    handlers.handlers = arrayOf(apicontext, wcon)

    server.handler = handlers

    server.start()
    server.join()

}