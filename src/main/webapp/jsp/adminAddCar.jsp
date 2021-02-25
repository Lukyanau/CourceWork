<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
</head>
<body style="background-image: url(${pageContext.request.contextPath}/images/adminAddCar.jpg);background-size: cover;">
<form class="form-compact" action="">
    <div class="row paddingBottom20">
        <div class="container col-4">
            <div class="row">
                <h6 class="text-center col-12 mb-0">Car Information</h6>
                <sub class="text-right text-muted col-12"><a href="#" tabindex="-1"><i
                        class="far fa-edit"></i></a></sub>
            </div>
            <div class="dropdown-divider mb-3"></div>
            <div class="form-group row align-items-center">
                <label for="mark" class="col-4 col-form-label-sm text-right">Mark:</label>
                <div class="col-8">
                    <div class="input-group">
                        <select id="mark"  required name = "mark" class="form-control">
                            <option>BMW</option>
                            <option>MERCEDES</option>
                            <option>AUDI</option>
                            <option>TESLA</option>
                            <option>VOLKSWAGEN</option>
                            <option>PEUGEOT</option>
                            <option>RENAULT</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group row align-items-center">
                <label for="title" class="col-4 col-form-label-sm text-right">Title:</label>
                <div class="col-8">
                    <div class="input-group">
                        <input id="title" name="title" type="text" class="form-control form-control-sm" required pattern="^[a-zA-Z0-9 ]{2,25}$"
                               oninvalid="this.setCustomValidity('Name should contains only letters,numbers! From 2 to 25 symbols!')"
                               onchange="this.setCustomValidity('')">
                    </div>
                </div>
            </div>
            <div class="form-group row align-items-center">
                <label for="color" class="col-4 col-form-label-sm text-right" required pattern="^[a-zA-Z]{2,15}$"
                       oninvalid="this.setCustomValidity('Name should contains only letters! From 2 to 15 symbols!')"
                       onchange="this.setCustomValidity('')">Color:</label>
                <div class="col-8">
                    <div class="input-group">
                        <input id="color" name="color" type="text"
                               class="form-control form-control-sm">
                    </div>
                </div>
            </div>
            <div class="form-group row align-items-center">
                <label for="description" class="col-4 col-form-label-sm text-right" required pattern="^[a-zA-Z0-9 ]{3,30}$"
                       oninvalid="this.setCustomValidity('Name should contains only letters,numbers! From 3 to 30 symbols!')"
                       onchange="this.setCustomValidity('')">Description</label>
                <div class="col-8">
                    <div class="input-group">
                        <input id="description" name="description" type="text"
                               class="form-control form-control-sm extendable">
                    </div>
                </div>
            </div>
            <div class="form-group row align-items-center">
                <label for="price" class="col-4 col-form-label-sm text-right">Price:</label>
                <div class="col-8">
                    <div class="input-group">
                        <input id="price" name="price" type="number" class="form-control form-control-sm" >
                    </div>
                </div>
            </div>
            <input type="hidden" name="command" value="add_car"/>
            <input type="submit" value="Add Car" class="btn btn-info btn-block">
        </div>
    </div>

</form>
</body>
</html>
