<?xml version="1.0"?> 
<xsl:stylesheet version = "1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 

<xsl:template match="/"> 
	<html>
		<body>
			<div style="color:purple">
				<H1> LIST PLANES </H1> 
			</div>
			<xsl:apply-templates/> 
		</body>
	</html>
</xsl:template>   

    
<xsl:template match="Plane"> 
	<div style="color:purple">

	  <H2> PLANE:  
	  <xsl:text> model: </xsl:text> 
          <xsl:value-of select="@model"/>
	  <xsl:text>; </xsl:text> 
 
	  <xsl:text> origin: </xsl:text> 
          <xsl:value-of select="@origin"/> 
	  <xsl:text>; </xsl:text> 

	  <xsl:text> price: </xsl:text> 
          <xsl:value-of select="@price"/>
	  <xsl:text>. </xsl:text> 
	  </H2> 
	  <xsl:apply-templates/> 
	</div>
</xsl:template> 
<xsl:template match="Chars">
	<div style="color:black">
	  <H3> The main characteristics of plane </H3> 
 	  <xsl:apply-templates/> 
	</div>
</xsl:template> 

<xsl:template match="type">
	  <xsl:value-of select="name()"/> 
   	  <xsl:text> - </xsl:text>
	  <xsl:apply-templates/> 
</xsl:template> 

<xsl:template match="seats">
	  <xsl:value-of select="name()"/> 
   	  <xsl:text> - </xsl:text>
	  <xsl:apply-templates/> 
</xsl:template> 

<xsl:template match="ammo">
	  <xsl:value-of select="name()"/> 
   	  <xsl:text> - </xsl:text>
	  <xsl:apply-templates/> 
</xsl:template> 

<xsl:template match="rocket">
	  <xsl:value-of select="name()"/> 
   	  <xsl:text> - </xsl:text>
	  <xsl:apply-templates/> 
</xsl:template> 

<xsl:template match="radar">
	  <xsl:value-of select="name()"/> 
   	  <xsl:text> - </xsl:text>
	  <xsl:apply-templates/> 
</xsl:template> 

<xsl:template match="Parameters">
	<div style="color:black">
	  <H3> Technical characteristics of the plane </H3> 
 	  <xsl:apply-templates/> 
	</div>
</xsl:template> 

<xsl:template match="Length">
	  <xsl:value-of select="name()"/> 
   	  <xsl:text> - </xsl:text>
	  <xsl:apply-templates/> 
</xsl:template> 

<xsl:template match="Width">
	  <xsl:value-of select="name()"/> 
   	  <xsl:text> - </xsl:text>
	  <xsl:apply-templates/> 
</xsl:template> 


<xsl:template match="Height">
	  <xsl:value-of select="name()"/>
   	  <xsl:text> - </xsl:text>  
	  <xsl:apply-templates/> 
</xsl:template> 

<xsl:template match="text()">
   <xsl:value-of select="."/>
   <br> </br> 
</xsl:template>

</xsl:stylesheet> 



  