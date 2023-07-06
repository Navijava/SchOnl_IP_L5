<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width" />
    <title>Welcome!</title>

    <style>
        * {
            box-sizing: border-box;
        }

        html,
        body {
            padding: 0;
            margin: 0;
            font-family: Montserrat;
            font-size: 18px;
            font-weight: 500;
        }

        body {
            color: black;
            font-size: 18px;
            padding: 0;
            display: flex;
            flex-direction: column;
        }

        main {
            display: flex;
            flex-direction: column;
        }

        article {
            text-align: center;
            background-color: yellow;
            flex: 2 2 12em;
            padding: 1em;
            font-weight: 600;
            font-size: 18px;
            font-family: montserrat;
        }

        nav,
        aside {
            flex: 1;
            background-color: deepskyblue;
            text-align: center;
            font-size:64px;
            font-weight: 800;
            color: greenyellow;
        }

        nav {
            order: -1;
        }

        header,
        footer {
            color: greenyellow;
            text-align: center;
            background-color: deepskyblue;
            font-size: 56px;
            font-weight: 900;
        }

        @media screen and (min-width: 600px) {

            body {
                min-height: 100vh;
            }

            main {
                flex-direction: row;
                min-height: 100%;
                flex: 1 1 auto;
            }
        }

        a:link {
            color: darkblue;
            text-decoration: none
        }

        a:visited {
            color: blue;
            text-decoration: none
        }

        a:hover {
            color: cornflowerblue;
            text-decoration: underline
        }

        a:active {
            color: orange;
            text-decoration: underline
        }
    </style>


</head>

<body>
<header>
    <p>Welcome to our School Online!</p>
</header>
<main>
    <article>

        <br/>
        <a href="webMain">About us.</a>
        <br/><br/>
        <a href="hello">Greetings!</a>
        <br/><br/>

    </article>

    <nav>
        <p>Start!</p>
    </nav>
    <aside>
        <p>Success!</p>
    </aside>
</main>
<footer>
    <p>Welcome to our School Online!</p>
</footer>
</body>

</html>