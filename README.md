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

Simply include the <context:annotation-config> element in your bean configuration file.

<b>AutoDiscovery of bean</b><br>
<ul type="circle">
<li><context:component-scan base-package="com.spring.example.controller"/></li>
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


