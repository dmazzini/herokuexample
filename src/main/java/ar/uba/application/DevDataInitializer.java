package ar.uba.application;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.google.common.collect.ImmutableSet;
import com.google.common.io.ByteStreams;

import ar.uba.domain.Category;
import ar.uba.domain.InterestingPoint;
import ar.uba.domain.InterestingPointFilterSpec;
import ar.uba.domain.Role;
import ar.uba.domain.User;
import ar.uba.service.CategoryRepository;
import ar.uba.service.CategoryService;
import ar.uba.service.InterestingPointRepository;
import ar.uba.service.InterestingPointService;
import ar.uba.service.RoleRepository;
import ar.uba.service.UserRepository;
import ar.uba.service.UserService;

@Configuration
@Profile({"dev"})
public class DevDataInitializer implements DataInitializer {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private InterestingPointRepository interestingPointRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private InterestingPointService interestingPointService;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Bean
	@Override
	public void initializeData() {
		initializeRolesAndAdminUser();
		initializeCategoriesAndInterestingPoints();
	}

	private void initializeRolesAndAdminUser() {
		Role role = new Role();
		role.setId(1);
		role.setRole("SUPER_USER");
		role.setDesc("This user has ultimate rights for everything");
		roleRepository.save(role);
		
		role = new Role();
		role.setId(2);
		role.setRole("ADMIN_USER");
		role.setDesc("This user has admin rights for administrative work");
		roleRepository.save(role);
		
		role = new Role();
		role.setId(3);
		role.setRole("SITE_USER");
		role.setDesc("This user has access to site, after login - normal user");
		roleRepository.save(role);

		User adminUser = new User();
		adminUser.setId(1);
		adminUser.setName("Admin");
		adminUser.setLastName("Admin");
		adminUser.setEmail("admin@admin.com");
		adminUser.setPassword("12345678");

		userService.saveAdminUser(adminUser);

		User user = new User();
		user.setId(2);
		user.setName("User");
		user.setLastName("user");
		user.setEmail("user@user.com");
		user.setPassword("12345678");

		userService.saveUser(user);
		
	}

	private void initializeCategoriesAndInterestingPoints() {
    	Category cat1 = new Category("cat");
   		Category cat2 = new Category("bat");
    	cat2.setHidden(true);
    	
    	InterestingPoint intp1 = new InterestingPoint(cat1, "for cat ", "descr");
    	intp1.setHidden(true);
    	InterestingPoint intp2 = new InterestingPoint(cat2, "cat 2 for", "descr");
    	
		try {
			byte[] image = ByteStreams.toByteArray(DevDataInitializer.class.getResourceAsStream("imagen1.jpg"));
	    	cat1.setLogo(image);
			intp1.setImage(image);

			image = ByteStreams.toByteArray(DevDataInitializer.class.getResourceAsStream("imagen2.jpg"));
	    	cat2.setLogo(image);
			intp2.setImage(image);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		categoryRepository.save(cat1);
    	categoryRepository.save(cat2);
		
    	interestingPointRepository.save(intp1);
		interestingPointRepository.save(intp2);
    	
    	System.out.println(categoryService.getAllCategories());
    	System.out.println(categoryService.getAllCategoriesByHidden(true));
    	System.out.println(categoryService.getAllCategoriesByHidden(false));
    	
    	System.out.println("=====");
    	System.out.println(interestingPointService.getAllFilteredBy(new InterestingPointFilterSpec(true, ImmutableSet.of(), null)));
    	System.out.println(interestingPointService.getAllFilteredBy(new InterestingPointFilterSpec(false, ImmutableSet.of(), null)));
    	System.out.println(interestingPointService.getAllFilteredBy(new InterestingPointFilterSpec(null, ImmutableSet.of(cat1), null)));
    	System.out.println(interestingPointService.getAllFilteredBy(new InterestingPointFilterSpec(null, ImmutableSet.of(cat2), null)));
    	System.out.println(interestingPointService.getAllFilteredBy(new InterestingPointFilterSpec(null, ImmutableSet.of(), null)));

    	System.out.println("=====");
	}

	
}