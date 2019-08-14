# EJB JNDI Lookup
* life-cycle of EJBs is handled by an application server
* create a EJB module and call it from remote via JNDI
* __local__ business interfaces (bean) is used when accessing it from __same__ environment (same vm / appserver)
* __remote__ business interfaces (bean) is used when accessing it from __different__ environment (same vm / appserver)
