# Developer's Notebook <hr>

### Development Logs

* application-properties configuration
* server port
* rest controller / controller
* response body
* adding prefix and suffix to view
* request parameters
* ModelMap
* Returning jsp view
* logger
* Front Controller pattern
* Dispatcher Servlet
* Session vs Models vs Request
* Starter Validation (jakarta validation api):  
        - command bean (form backing object)
        - 2 way binding
        - @Size
        - @Valid
        - Binding Result
* spring mvc date formatter
* spring boot starter security
* InMemoryUserDetailsManager, UserDetails
* Password Encoder, BCryptPasswordEncoder, 
* Authentication from spring SecurityContextHolder

### Guides
* **Change Server Port** (app-props file) : ```server.port=????```
* **HTTP Response Body** (without View) : ```@ResponseBody```
* **Adding Prefix to view** (app-props file) : ```spring.mvc.view.prefix=```
* **Adding Suffix to view** (app-props file) : ```spring.mvc.view.suffix=```
* **Logging** : ```private Logger logger = LoggerFactory.getLogger(getClass()); logger.*()```
* **Set Validation Constraint** (in domain) : ```@Size(min=?, message=?), @Valid```
* **Set Date Format** (app-props file) : ```spring.mvc.format.date=yyyy/MM/dd```

### How is it Working (Work-Flow) ?

> #### **Dispatcher Servlet** :  
> s1. Request Sent From Browser (localhost:8080/*)\
> s2. Received by Dispatcher Servlet  
> s3. DS finds the controller handling that specific request  
> s4. Method gets executed  
> s5. Model and ViewName is returned to DS  
> s6. DS resolves view name by View Resolver (prefix + ViewName + suffix)  
> s7. Model data collected by jsp and returns Jsp View  
> s8. DS sends the response   
<hr>

### To-dos
* watch video = 
* add css = /META-INF/resources/webjars/bootstrap/5.3.0/css/bootstrap.min.css
* add js = /META-INF/resources/webjars/bootstrap/5.3.0/js/bootstrap.min.js
* add jquery = /META-INF/resources/webjars/jquery/3.7.1/dist/jquery.min.js
* add bootstrap datepicker script - ```<script type="text/javascript">
  $(function () {
  $('#datetimepicker10').datetimepicker({
  viewMode: 'years',
  format: 'MM/YYYY'
  });
  });
  </script>```
* add bs date picker css = webjars\bootstrap-datepicker\1.10.0\css\bootstrap-datepicker.min.css
* add bs date picker js = webjars\bootstrap-datepicker\1.10.0\js\bootstrap-datepicker.min.js