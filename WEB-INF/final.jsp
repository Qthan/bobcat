<%! private String names[] = {"low", "kastrato", "lion"}; %>
    <jsp:include page="header.jsp" />
        <div class="custom">
            <%=session.getAttribute("fname")%> <%=session.getAttribute("sname")%> 
        </div>
		<h1> Your order has been placed. </h1>
		<table>
			<tr>
				<th>Book</th> <th>Quantity</th>
			</tr>
		<%
			Cookie cookies[] = request.getCookies();
			if ( cookies.length > 1 ) { 
				for( int i = 0 ; i < ( cookies.length ) ; i++ ) {
					String name = cookies[i].getName();
					if (name.equals("1")){ %>
						<tr>
							<td>2001: A Space Odyssey, Arthur C. Clarke</td> <td><%=cookies[i].getValue()%></td>
						</tr> 
					<% }
					else if (name.equals("2")){ %>
						<tr>
							<td>The Hitchhiker's Guide to the Galaxy, Douglas Adams</td> <td><%=cookies[i].getValue()%></td>
						</tr> 
					<% }
					else if (name.equals("3")){ %>
						<tr>
							<td>Signals and Systems, Alan V. Oppenheim</td> <td><%=cookies[i].getValue()%></td>
						</tr> 
					<% }
					else if (name.equals("4")){ %>
						<tr>
							<td>The Piper at the Gates of Dawn, Pink Floyd</td> <td><%=cookies[i].getValue()%></td>
						</tr> 
					<% }
					else if (name.equals("5")){ %>
						<tr>
							<td>Lightbulb Sun, Porcupine Tree</td> <td><%=cookies[i].getValue()%></td>
						</tr> 
					<% }
					else if (name.equals("6")){ %>
						<tr>
							<td>Banana, The Velvet Underground</td> <td><%=cookies[i].getValue()%></td>
						</tr> 
					<% }
				}
			}
			else{ %>	
					<tr><td> Cart Empty </td></tr>
			<% }
			%>
		</table>

    <p>
        <a href = 'http://localhost:8080/bobcat'>home</a>
    </p>
    <jsp:include page="footer.jsp" />

