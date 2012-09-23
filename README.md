LDRAW4J
=======

LDRAW4J is a Java-based implementation of the
[LDRAW](http://www.ldraw.org/) [file
format](http://www.ldraw.org/reference/specs/fileformat.shtml).  It is
fairly "thin" in that it reads LDRAW files directly without doing any
useful transformations, like canonicalizing winding directions, but is
also (fairly) complete.

LDRAW4J is under active development, and so should be considered alpha
software. However, it is already good enough to allow simple
renderings, like the one below:

![Example LDRAW4J Rendering](http://i.imgur.com/NkLbw.png)

Please note that LDRAW4J implements the *file reading engine only.*
The rendering engine is left as an "exercise for the reader," although
I hope to have some code to that effect to share soon, as well.
