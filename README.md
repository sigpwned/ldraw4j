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

LDRAW4J is released under [the Apache 2.0
license](http://www.apache.org/licenses/LICENSE-2.0.html), so please
feel free to use this code however you like as long as you retain an
attribution back to me and this project. Also, if you end up using
LDRAW4J, I'd love to know about it, so I'd consider it a courtesy if
you dropped me a line on Twitter @sigpwned! :)
