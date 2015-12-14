package jettyserver.contexts;

import jettyserver.AbstractJettyWebapp;
import jettyserver.handlers.hellohandler.HelloHandler;
import org.eclipse.jetty.server.handler.ContextHandler;

/**
 * A ContextHandler is a ScopedHandler that responds only to requests that have a URI prefix
 * that matches the configured context path.
 *
 * Requests that match the context path have their path methods updated accordingly and the contexts scope is available,
 * which optionally may include:
 *  - A Classloader that is set as the Thread context classloader while request handling is in scope.
 *  - A set of attributes that is available via the ServletContext API.
 *  - A set of init parameters that is available via the ServletContext API.
 *  - A base Resource which is used as the document root for static resource requests via the ServletContext API.
 *
 *  A set of virtual host names.
 */
public class OneContext extends AbstractJettyWebapp {
  @Override
  public void configure() {
    ContextHandler context = new ContextHandler();
    context.setContextPath("/hello");
    context.setHandler(new HelloHandler());
    server.setHandler(context);
  }

  public static void main(String[] args) {
    new OneContext().start();
  }
}
