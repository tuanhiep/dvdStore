/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cart.ShoppingCart;
import entity.Dvd;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.AuteurFacade;
import session.CommandeFacade;
import session.DvdFacade;
import session.FournisseurFacade;
import session.OrderManager;
import session.RealisateurFacade;
import validate.Validator;

/**
 *
 * @author cuongmv
 */
@WebServlet(name = "Controller",
        loadOnStartup = 1,
        urlPatterns = {
            "/search-result",
            "/addToCartFromIndex",
            "/addToCartFromResult",
            "/addToCartFromDVD",
            "/viewCart",
            "/checkout",
            "/purchase",
            "/chooseLanguage",
            "/dvd",
            "/updateCart",
            "/admin",
            "/add-new-dvd",
            "/pending-command",
            "/ongoing-command",
            "/all-command",
            "/createDVD",
            "/deleteDVD",
            "/executed-command",
            "/editDVD",
            "/command",
            "/updateDVD"
        })
public class ControllerServlet extends HttpServlet {

    private String surcharge;
    @EJB
    private DvdFacade dvdFacade;
    @EJB
    private OrderManager orderManager;
    @EJB
    private AuteurFacade auteurFacade;
    @EJB
    private RealisateurFacade realisateurFacade;
    @EJB
    private FournisseurFacade fournisseurFacade;
    @EJB
    private CommandeFacade commandeFacade;

    /**
     * Initialize the servlet
     *
     * @param servletConfig
     * @throws javax.servlet.ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);

        // initialize servlet with configuration information
        surcharge = servletConfig.getServletContext().getInitParameter("deliverySurcharge");
        // Store the DVDss list in the servlet context
        getServletContext().setAttribute("dvds", dvdFacade.findAll());
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *     
* @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        // if category page is requested
        switch (userPath) {
            case "/search-result":
                break;
            case "/viewCart":
                // TODO: Implement cart page request
                String clear = request.getParameter("clear");
                if ((clear != null) && clear.equals("true")) {

                    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                    cart.clear();
                }
                userPath = "/cart";

                // if checkout page is requested
                break;
            case "/checkout":
                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

                // calculate total
                cart.calculateTotal(surcharge);

                // forward to checkout page and switch to a secure channel 
                break;
            case "/dvd":
                String dvdId = request.getQueryString();
                if (dvdId != null) {
                    Dvd selectedDvd = dvdFacade.find(Integer.parseInt(request.getQueryString()));
                    // Place the selected DVD in request scope
                    session.setAttribute("selectedDvd", selectedDvd);
                }
                break;
            case "/admin":
                session.setAttribute("dvds", dvdFacade.findAll());
                break;
            case "/command":
                String commandeId = request.getQueryString();
                Map commandeMap = orderManager.getCommandeDetails(Integer.parseInt(commandeId));
                // place order details in request scope
                request.setAttribute("client", commandeMap.get("client"));
                request.setAttribute("dvdCorrespondants", commandeMap.get("dvds"));
                request.setAttribute("commandeRecord", commandeMap.get("commandeRecord"));
                request.setAttribute("dvdCommandes", commandeMap.get("dvdCommandes"));
                break;

        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        Validator validator = new Validator();
        // if addToCart action is called
        switch (userPath) {
            case "/addToCartFromIndex": {
                // if user is adding item to cart for first time
                // create cart object and attach it to user session
                if (cart == null) {
                    cart = new ShoppingCart();
                    session.setAttribute("cart", cart);
                }       // get user input from request
                String dvdId = request.getParameter("dvdId");
                if (!dvdId.isEmpty()) {

                    Dvd dvd = dvdFacade.find(Integer.parseInt(dvdId));
                    cart.addItem(dvd);
                }
                userPath = "/index";
                break;
            }
            case "/addToCartFromResult": {
                // if user is adding item to cart for first time
                // create cart object and attach it to user session
                if (cart == null) {
                    cart = new ShoppingCart();
                    session.setAttribute("cart", cart);
                }       // get user input from request
                String dvdId = request.getParameter("dvdId");
                if (!dvdId.isEmpty()) {

                    Dvd dvd = dvdFacade.find(Integer.parseInt(dvdId));
                    cart.addItem(dvd);
                }
                userPath = "/search-result";
                break;
            }
            case "/addToCartFromDVD": {
                // if user is adding item to cart for first time
                // create cart object and attach it to user session
                if (cart == null) {
                    cart = new ShoppingCart();
                    session.setAttribute("cart", cart);
                }       // get user input from request
                String dvdId = request.getParameter("dvdId");
                if (!dvdId.isEmpty()) {

                    Dvd dvd = dvdFacade.find(Integer.parseInt(dvdId));
                    cart.addItem(dvd);
                }
                userPath = "/dvd";
                break;
            }
            case "/updateCart": {
                // get input from request
                String dvdId = request.getParameter("dvdId");
                String quantity = request.getParameter("quantity");
                Dvd dvd = dvdFacade.find(Integer.parseInt(dvdId));
                cart.update(dvd, quantity);
                userPath = "/cart";

                // if purchase action is called
                break;
            }
            case "/purchase":
                if (cart != null) {

                    // extract user data from request
                    String name = request.getParameter("name");
                    String email = request.getParameter("email");
                    String phone = request.getParameter("phone");
                    String address = request.getParameter("address");
                    String ccNumber = request.getParameter("creditcard");

                    // validate user data
                    boolean validationErrorFlag = false;
                    validationErrorFlag = validator.validateForm(name, email, phone, address, ccNumber, request);
                    // if validation error found, return user to checkout
                    if (validationErrorFlag == true) {
                        request.setAttribute("validationErrorFlag", validationErrorFlag);
                        userPath = "/checkout";

                        // otherwise, save order to database
                    } else {

                        int commandeId = orderManager.FaireCommande(name, email, phone, address, ccNumber, cart);

                        // if order processed successfully send user to confirmation page
                        if (commandeId != 0) {

                            // dissociate shopping cart from session
                            cart = null;

                            // end session
                            session.invalidate();

                            // get order details
                            Map commandeMap = orderManager.getCommandeDetails(commandeId);

                            // place order details in request scope
                            request.setAttribute("client", commandeMap.get("client"));
                            request.setAttribute("dvdCorrespondants", commandeMap.get("dvds"));
                            request.setAttribute("commandeRecord", commandeMap.get("commandeRecord"));
                            request.setAttribute("dvdCommandes", commandeMap.get("dvdCommandes"));

                            userPath = "/confirm";

                            // otherwise, send back to checkout page and display error
                        } else {
                            userPath = "/checkout";
                            request.setAttribute("orderFailureFlag", true);
                        }
                    }

                }

                break;
            case "/editDVD":

                String DvdId = request.getParameter("editDVDId");
                if (DvdId != null) {
                    Dvd selectedDvd = dvdFacade.find(Integer.parseInt(DvdId));
                    // Place the selected DVD in request scope
                    session.setAttribute("selectedDvd", selectedDvd);
                }
                session.setAttribute("dvds", dvdFacade.findAll());
                session.setAttribute("auteurs", auteurFacade.findAll());
                session.setAttribute("realisateurs", realisateurFacade.findAll());
                session.setAttribute("fournisseurs", fournisseurFacade.findAll());
                break;

            case "/add-new-dvd":
                session.setAttribute("dvds", dvdFacade.findAll());
                session.setAttribute("auteurs", auteurFacade.findAll());
                session.setAttribute("realisateurs", realisateurFacade.findAll());
                session.setAttribute("fournisseurs", fournisseurFacade.findAll());
                break;
            case "/createDVD":

                String name = request.getParameter("newName");
                String auteurId = request.getParameter("auteurList");
                String realisateurId = request.getParameter("realisateurList");
                String fournisseurId = request.getParameter("fournisseurList");
                String dateRelease = request.getParameter("selectedDate");
                String price = request.getParameter("newPrice");
                String description = request.getParameter("newDescription");
                String quantity = request.getParameter("newQuantity");
                int dvdId = dvdFacade.addDvd(name, price, quantity, description, auteurId, fournisseurId, realisateurId);
                if (dvdId != 0) {
                    userPath = "/admin";
                    session.setAttribute("dvds", dvdFacade.findAll());
                } else {
                    userPath = "/add-new-dvd";
                }
                break;
            case "/deleteDVD":
                String dvdID = request.getParameter("dvdId");
                if (!dvdID.isEmpty()) {

                    Dvd dvd = dvdFacade.find(Integer.parseInt(dvdID));
                    dvdFacade.remove(dvd);
                    userPath = "/admin";
                    session.setAttribute("dvds", dvdFacade.findAll());
                }
                break;
            case "/updateDVD":
                String selectedDvdId = request.getParameter("selectedDvdId");
                if (!selectedDvdId.isEmpty()) {
                    Dvd selectedEditDVD;
                    selectedEditDVD = dvdFacade.find(Integer.parseInt(selectedDvdId));

                    selectedEditDVD.setName(request.getParameter("newName"));
                    selectedEditDVD.setAuteurId(auteurFacade.find(Integer.parseInt(request.getParameter("auteurList"))));
                    selectedEditDVD.setRealisateurId(realisateurFacade.find(Integer.parseInt(request.getParameter("realisateurList"))));
                    selectedEditDVD.setPrice(BigDecimal.valueOf(Double.parseDouble(request.getParameter("newPrice"))));
                    selectedEditDVD.setDescription(request.getParameter("newDescription"));
                    selectedEditDVD.setQuantitystock(Integer.parseInt(request.getParameter("newQuantity")));
                    userPath = "/admin";

                    dvdFacade.edit(selectedEditDVD);
                    session.setAttribute("dvds", dvdFacade.findAll());
                }

                break;
            case "/all-command":
                commandeFacade.processCommande();
                session.setAttribute("commandes", commandeFacade.findAll());

                break;
            case "/pending-command":
                commandeFacade.processCommande();
                session.setAttribute("pendingMap", commandeFacade.processCommande());
                break;
            case "/ongoing-command":
                commandeFacade.processCommande();
                session.setAttribute("ongoingCommandes", commandeFacade.getOngoingCommande());
                break;
            case "/executed-comand":
                commandeFacade.processCommande();
                session.setAttribute("executedCommandes", commandeFacade.getExecutedCommande());
            case "/search-result":
                String search_text = request.getParameter("searchText");
                String search_type = request.getParameter("searchType");
                switch (search_type) {
                    case "DVD":
                        request.getSession().setAttribute("dvdFound", this.dvdFacade.getByName(search_text));
                        break;
                    case "Réalisateur":
                        request.getSession().setAttribute("dvdFound", this.dvdFacade.getByRealisateur(search_text));
                        break;
                    case "Auteur":
                        request.getSession().setAttribute("dvdFound", this.dvdFacade.getByAuteur(search_text));
                        break;
                }
        }
        String url;
        if (!userPath.equals("/index")) {
            // use RequestDispatcher to forward request internally
            url = "/WEB-INF/view" + userPath + ".jsp";
        } else {
            // use RequestDispatcher to forward request internally
            url = userPath + ".jsp";
        }
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
