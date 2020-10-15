# ComplaintBox
Technologies- JAVA, Spring Boot ,Hibernate, JPA, RestAPI

# Use case:
<li>A company has many employees, employees can be added or removed anytime by themselves or admin (No need to create API for this) - Non functional requirement <br/>
<li>A company has a complaint management system , they are of two types i.e Internal and External - Non functional requirement <br />
<li>Internal complaints are managed internally by company while external can be handled by a vendor depending upon job type . - Non functional requirement <br />
<li>An employee should be never aware of whether complaint is handled by external vendor or company - Non functional requirement <br />

# API:
<li>An employee can file for a complaint on any job type (i.e Desk, laptop, Mobile, Transport) and it should be seamlessly routed to the correct vendor - API <br />
<li>A new vendor can be added or removed by admin - API <br />
<li>An employee can find all open jobs, all jobs with their respective status created by them  (only its job)- API <br />
<li>An employee can filter job based on its status and created time and type(only its job) - API <br />
<li>An Admin can find all jobs with its status in the system - API <br />
