
# Section 01: Introduction.

# What I learned.

# Introduction.

- Some cool music here! La la la la.

# What is Spring Integration?



<div align="center">
    <img src="whatIsSpringIntegrationsMain.png" alt="ticket" width="600">
</div>


<div align="center">
    <img src="whatIsSpringIntegration.png" alt="ticket" width="600">
</div>

1. **Spring Integration** is open source framework for the **enterprise application integrations**.

- **Spring Integrations**, supports external systems and other spring beans applications.

<div align="center">
    <img src="basicSpringIntegration.png" alt="ticket" width="600">
</div>

1. **Producer**(Sender) sends message trought the **Channel/Pipe**.
2. This goes to the **Consumer**(Reaceiver).


<div align="center">
    <img src="transformersAndFilter.png" alt="ticket" width="600">
</div>

1. **Transformer** converts the content of the message.
2. **Filter** decides does the message continue to the output channel!

<div align="center">
    <img src="transformersAndFilterDiagram.png" alt="ticket" width="600">
</div>

1. **Input channel** inputting into the **Component**.
2. **Component** is outputting the message to the **output channel** with the  **Filter** or the **Transformer**.

<div align="center">
    <img src="router.png" alt="ticket" width="600">
</div>

1. The **router** decides, to which **channel** to sends the message. 

<div align="center">
    <img src="routerDiagram.png" alt="ticket" width="600">
</div>

1. The **router** in the **compoment** gets the message. It **decides**, to which **channel** it sends it. This is based on the criteria. 

<div align="center">
    <img src="splitterAndTheAggregator.png" alt="ticket" width="600">
</div>

1. **Splitter splits** the message into the **several** parts.
2. **Aggregator** combines several message into the **single one**.

<div align="center">
    <img src="splitterAndTheAggregatorDiagram.png" alt="ticket" width="600">
</div>

1. **Splitter** splits into message into **multiple parts**.
2. **Aggrigator** combines several message into **singe one**.

<div align="center">
    <img src="ServiceActivator.png" alt="ticket" width="600">
</div>

<div align="center">
    <img src="ServiceActivator_1.png" alt="ticket" width="600">
</div>

1. **Service Activator** can be used to `invoke` operations on the **service bean**.

- Additional link to refresh the [Service Activator](https://www.youtube.com/watch?v=vK71__HgN4E).

<div align="center">
    <img src="ServiceActivatorDiagram.png" alt="ticket" width="600">
</div>

1. **Input Channel** send message to the **Service Activator**. Redirects it to the **Service Bean**.
2. If, the **Service Bean** decides to output message, it sends it to back to the **Service Activator** and then to **Output Channel**.


<div align="center">
    <img src="ChannelAdapter.png" alt="ticket" width="600">
</div>

1. **Channel adapter** connects the application to **external systen**. Flow here is to both ways(**unidirectional)**. 

<div align="center">
    <img src="ChannelAdapterDiagram.png" alt="ticket" width="600">
</div>

1. Flow goes from **outside** to **inside**.
2. Flow goes from **inside** to **outside**.


