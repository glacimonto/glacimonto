# Glacimonto

Glacimonto is an opinionated test framework.

It was inspired by the practice of Acceptance-Test Driven Development (and Specification by Example) and created to fill the gap between functional requirements and their hidden tests _glue code_.

Glacimonto name was inspired by Seb Rose, who's idea was to revised the test pyramid metaphor according to test readability and readers ability :
[The Testing Iceberg](http://claysnow.co.uk/the-testing-iceberg/)

We envisioned a tool allowing multiple levels of readability, providing a single place for our beloved _three amigos_ (business analysts or domain experts, testers and developers) to co-create, share and execute their acceptance tests, forming a real living documentation.

And since we are a bunch of staunch polyglots, we picked the name from Esperanto.
And thus,

Glacimonto was born.

# Use case

At the moment, Glacimonto aims to test deployed software in order to validate functional requirements before launch in production.

Other usage such as security or performance testing might be considered but not guaranteed (optimization or specific features).

It is itself a deployed software with a test execution engine and a web front end to create and edit your scenarios, manage them, analyse results, and define your test environment.

At the moment, we do not enforce usage of a BDD writing style (Given-When-Then, also known as Gherkin language) but we highly recommend it.

__Glacimonto is no silver-bullet, it is just a tool which promotes and supports one way of doing software testing.__

As such, to benefit from it, we highly advise you to be proficient or to document yourself about Behaviour-Driven-Development (by Dan North), Specification by Example (by Gojko Adzic) and Living Documentation (by Cyrille Martraire).

Global understanding of Test Driven Development and knowledge about Ubiquitous Language (from Domain Driven Design, by Eric Evans) is also valuable.
