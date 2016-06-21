# SpringCoreExample
Simple JavaProject without annotation

Spring Framework- Basic Level
-----------------------------
<b>Core Spring:</b><br>
	<ul><li>Dependency Injection</li>
	<li>Bean Scope</li>
	<li>Autowiring</li>
	<li>Spring Container (IoC)</li>
	<li>Bean Life Cycle</li>
	<li>Internationalization</li>
	<li>ApplicationContextAware,BeanNameAware</li>
	<li>Spring Jdbc</li>
	</ul>
<hr>
<b>Why Spring?</b><br>
	<ul><li>loose coupling through dependency injection</li>
	<li>aspect oriented programming</li>
	<li>light weight</li>
	<li>jdbc templates, easier integration.</li></ul>
	
<hr>	
<b>Dependencies:</b><br>
        
        
        public interface Instrument{
        	public void play();
        }
        public class Piano implements Instrument{
        	@Override
        	public void play(){
        		SOP("plink plink")
        	}
        }
        
        public class Drum implements Instrument{
        	@Override
        	public void play(){
        		SOP("dum dum");
        	}
        }
        
        public class InstrumentList{
        	private Instrument instrument=new Piano();
        	
        	public void perform(){
        		instrument.play();
        	}
        }

<hr>
<b>Type of Dependency Injection:</b><br>
	<ul><li>Setter Injection</li>
	<li>Constructor Injection</li>
	<li>Interface Injection</li></ul>
	
<hr>
<b>IOC (Inversion of control) Container:</b><br>
<p>managed the creation of object using configuration file.</p><br>
<p>There are two types of IOC container:</p><br>
	<ul><li>BeanFactory (legacy)</li>
	<li>ApplicationContext -Support Internationlization, Event publishing, Automatic BeanPostProcessor</li></ul>

<b>ApplicationContext</b><br>
<ul type="circle">
	<li>The Application Context is spring's more advance container.</li>
	<li>It includes all functionality of BeanFactory.</li>
	<li>Similar to BeanFactory it can load bean definition,wire beans together and dispose bean upon request.</li>
	<li>additionaly it adds more enterprise-specific functionality.</li>
	<li>It support Internationalization and Event publishing.</li>
</ul>

<b>ApplicationContext Implementation:</b>
<ul>
<li><b>FileSystemXmlApplicationContext:</b>This container loads the definitions of bean from XML file.<br>Here XML file will be search from Operating System File path.</li>
<li><b>ClassPathXmlApplicationContext:</b>This container loads the definitions of bean from XML file.<br>Here XML file will be search from CLASSPATH path.</li>
<li><b>XmlWebApplicationContext:</b>This container loads the definitions of bean from XML file within Web Application.</li>
</ul>
<hr>
<b>Bean Scope:</b><br>
<ul>
 <li>Singleton: Creates single bean instance per Spring IoC Container.</li>
 <li>prototype: Creates new instance each time requested.</li>
 <li>request: Creates a single bean instance per HTTP request. only valid in context of WebApplication.</li>
 <li>session: Creates a single bean insatnce per HTTP session only valid in context of WebApplication.</li>
 <li>globalSession: Creates a single bean instance per global HTTP session, only valid in context of portal application.</li>
</ul>

<hr>
<b>Autowiring:</b><br>
<p>implicitly injecting the collborate objects.</p>
<p>By following ways we can achieve autowiring:</p>
<ul>
<li>no (default)</li>
<li>byName</li>
<li>byType</li>
<li>constructor</li>
</ul>

<hr>
<b>using Annotation:</b><br>

<p>Simply include the : context:annotation-config  element in your bean configuration file.</p>

<b>AutoDiscovery of bean</b><br>
<ul type="circle">
<li>context:component-scan base-package="com.spring.example.controller"</li>
</ul>
<ul>
<li>@Component: A generl-purpose stereotype annotation indicating that the class is a Spring component.</li>
<li>@Controller: Indicates that the class is Spring MVC controller.</li>
<li>@Repository: indicates that class defines data repository.</li>
<li>@Service: indicates that class defines service.</li>
</ul>

<hr>
<b>Inheritance Mapping:</b><br>


      <bean id="superClass" abstract="true" class="com.springexample.SuperClass">
      	<property name="name" value="parent"/>
      </bean>
      
      <bean id="derivedClass" class="com.springexample.DerivedClass" parent="superClass">
      	<property name="name" value="override"/>
      </bean>

<hr>
<b>Collection Wiring:</b><br>
<ul>
<li>list</li>
<li>set</li>
<li>map</li>
<li>props</li>
</ul>

<b>Example:</b><br>

	<property name="testListValue">
		<list value-type="int">
			<value>5</value>
			<value>15</value>
			<value>5</value>
			<value>20</value>
		</list>
	</property>
	
	<property name="emails">
		<props>
			<prop key="administrator">admin@mymail.com</prop>
			<prop key="support">support@mymail.com</prop>
		</props>
	</property>
	
	<property name="govtIds">
		<map>
			<entry key="PANCARD" value="BAKSK7836H"></entry>
			<entry key="ELECTIONCARD" value="A123Z004"></entry>
			<entry key="DRIVINGLICENSE" value="DL1020167"></entry>
		</map>
	</property>
	
<hr>
<b>Bean Life Cycle:</b><br>

	<b>Instantiate -> Populate Properties -> BeanNameAware (setBeanName) 
	  -> BeanFactoryAware (setBeanFactory) -> ApplicationContextAware (setApplicationcontext)
	
	-> PreIntialization (BeanPreProcessor) -> Intializing Bean (afterPropertySet) -> Call custom init-method -> PostIntialization (BeanPostProcessor) 
	-> Ready to use -> shutdown -> DisposableBean (destroy) -> Call Custom destroy-method
	</b>

<hr>
<b>Database Access:</b><br>
<p>Using database access by pre-built Integration classes: </p>
<ul>
<li>JDBC:jdbcTemplate</li>
<li>JDO:JdoTemplate</li>
<li>Hibernate:HibernateTemplate</li>
<li>NamedParameterJdbcTemplate</li>
<li>SimpleJdbcTemplate</li>
<li>SimpleJdbcCall</li>
<li>SimpleJdbcInsert</li>
</ul>

<b>Data Source by JDBC Driver</b><br>
	<ul>
		<li><b>DriverManagerDataSource:</b>Returns a new connection every time that a connection is requested.</li>
		<li><b>SingleConnectionDatasource:</b>Returns the same connection every time that connection is required</li>
	</ul>

<b>Data Source with connection pooling</b><br>

		<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource>
			<property name="driverClassName" value="org.hsqldb.jdbcDriver"/>
			<property name="url" value="jdbc:jsqldb:hsql://localhost/myapp/mydb"/>
			<property name="username" value="root"/>
			<property name="password" value="password"/>
			<property name="intialSize" value="5"/>
			<property name="maxActive" value="10"/>
		</bean>
		
<b>Data Source by JNDI</b><br>

		<bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
			<property name="jndiName" value="/jdbc/mydbDataSource"/>
			<property name="resourceRef" value="true"/>
		</bean>
		
<b>Accessing JdbcTemplate</b><br>

		<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
			<property name="dataSource" ref="dataSource"/>
		</bean>
		
		<bean id="empDao" class="com.myapp.examples.dao.EmployeeDao">
			<property name="jdbcTemplate" ref="jdbcTemplate"/>
		</bean>

<b>Accessing HibernateTemplate</b><br>

		<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">  
			<property name="driverClassName"  value="oracle.jdbc.driver.OracleDriver"></property>  
			<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"></property>  
			<property name="username" value="system"></property>  
			<property name="password" value="oracle"></property>  
		</bean>  
		  
		<bean id="mysessionFactory"  class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">  
			<property name="dataSource" ref="dataSource"></property>  
			  
			<property name="mappingResources">  
				<list>  
					<value>employee.hbm.xml</value>  
				</list>  
			</property>  
			  
			<property name="hibernateProperties">  
				<props>  
					<prop key="hibernate.dialect">org.hibernate.dialect.Oracle9Dialect</prop>  
					<prop key="hibernate.hbm2ddl.auto">update</prop>  
					<prop key="hibernate.show_sql">true</prop>  
				</props>  
			</property>  
		</bean>  
		  
		<bean id="hibernateTemplate" class="org.springframework.orm.hibernate3.HibernateTemplate">  
			<property name="sessionFactory" ref="mysessionFactory"></property>  
		</bean>  
		  
		<bean id="empDao" class="com.javatpoint.EmployeeDao">  
			<property name="template" ref="hibernateTemplate"></property>  
		</bean>  
		
We can also mapped the bean class using annotation,if we use annotation based bean then following line will be changed in above session factory configuration

		<bean id="hibernateSessionFactory" class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean">
			<property name="dataSource" ref="myDataSource"/>
			<property name="annotatedClasses">
				<list>
					<value>org.springexamples.bean.Employee</value>
				</list>
			</property>
			<property name="hibernateProperties">
				<props>
					<prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
					<prop key="hibernate.show_sql">true</prop>
				</props>
			</property>
		</bean>

<b>NamedParameterJdbcTemplate:</b><br>
<p>Spring provides another way to insert data by named parameter. In such way, we use names instead of ?(question mark). </p>
<p>So it is better to remember the data for the column.</p>
<p>example:</p>
	insert into employee values (:id,:name,:salary)  

<b>SimpleJdbcCall:</b><br>
<p>A SimpleJdbcCall is a multi-threaded, reusable object representing a call to a stored procedure or a stored function. </p>
<p>It provides meta data processing to simplify the code needed to access basic stored procedures/functions. </p>
<p>All you need to provide is the name of the procedure/function and a Map containing the parameters when you execute the call. </p>
<p>The names of the supplied parameters will be matched up with in and out parameters declared when the stored procedure was created. </p>
